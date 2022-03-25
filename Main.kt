package parking

fun main() {
    var carPark = ParkingLot()
    var parkingLotExists = false
    var action = readln().split(" ")
    while (action.first() != "exit") {
        when (action.first()) {
            "create" -> { carPark = ParkingLot(action[1].toInt()); parkingLotExists = true }
            "park" -> carPark.park(Car(action[1], action[2]), parkingLotExists)
            "leave" -> carPark.leave(action[1].toInt(), parkingLotExists)
            "status" -> carPark.status(parkingLotExists)
            "reg_by_color" -> carPark.regByColor(action[1], parkingLotExists)
            "spot_by_color" -> carPark.spotByColor(action[1], parkingLotExists)
            "spot_by_reg" -> carPark.spotByReg(action[1], parkingLotExists)
        }
        action = readln().split(" ")
    }
}