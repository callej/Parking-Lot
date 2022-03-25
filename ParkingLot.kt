package parking

data class Car(val regNumber: String = "", val color: String = "")

class ParkingLot(private val size: Int = -1) {
    private val parkingLot = MutableList(size.coerceAtLeast(0)) { Car() }
    private val freeParingSpot = MutableList(size.coerceAtLeast(0)) { true }

    init {
        if (size >= 0) {
            println("Created a parking lot with $size spots.")
        }
    }

    private fun noParkingLot() {
        println("Sorry, a parking lot has not been created.")
    }

    fun park(car: Car, parkingLotExists: Boolean) {
        if (parkingLotExists) {
            val freeSpot = freeParingSpot.indexOf(true)
            if (freeSpot == -1) {
                println("Sorry, the parking lot is full.")
            } else {
                parkingLot[freeSpot] = car
                freeParingSpot[freeSpot] = false
                println("${car.color} car parked in spot ${freeSpot + 1}.")
            }
        } else {
            noParkingLot()
        }
    }

    fun leave(spot: Int, parkingLotExists: Boolean) {
        if (parkingLotExists) {
            if (freeParingSpot[spot - 1]) {
                println("There is no car in spot $spot.")
            } else {
                parkingLot[spot - 1] = Car()
                freeParingSpot[spot - 1] = true
                println("Spot $spot is free.")
            }
        } else {
            noParkingLot()
        }
    }

    fun status(parkingLotExists: Boolean) {
        if (parkingLotExists) {
            if (freeParingSpot.indexOf(false) == -1) {
                println("Parking lot is empty.")
            } else {
                for (spot in parkingLot.indices) {
                    if (!freeParingSpot[spot]) {
                        println("${spot + 1} ${parkingLot[spot].regNumber} ${parkingLot[spot].color}")
                    }
                }
            }
        } else {
            noParkingLot()
        }
    }

    fun regByColor(color: String, parkingLotExists: Boolean) {
        if (parkingLotExists) {
            val foundCars = emptyList<String>().toMutableList()
            for (car in parkingLot) {
                if (car.color.uppercase() == color.uppercase()) {
                    foundCars.add(car.regNumber)
                }
            }
            if (foundCars.isEmpty()) {
                println("No cars with color $color were found.")
            } else {
                println(foundCars.joinToString())
            }
        } else {
            noParkingLot()
        }
    }

    fun spotByColor(color: String, parkingLotExists: Boolean) {
        if (parkingLotExists) {
            val foundCars = emptyList<Int>().toMutableList()
            for (spot in parkingLot.indices) {
                if (parkingLot[spot].color.uppercase() == color.uppercase()) {
                    foundCars.add(spot + 1)
                }
            }
            if (foundCars.isEmpty()) {
                println("No cars with color $color were found.")
            } else {
                println(foundCars.joinToString())
            }
        } else {
            noParkingLot()
        }
    }

    fun spotByReg(regNumber: String, parkingLotExists: Boolean) {
        if (parkingLotExists) {
            for (spot in parkingLot.indices) {
                if (parkingLot[spot].regNumber == regNumber) {
                    println(spot + 1)
                    return
                }
            }
            println("No cars with registration number $regNumber were found.")
        } else {
            noParkingLot()
        }
    }
}