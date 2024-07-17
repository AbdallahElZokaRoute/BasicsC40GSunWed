package com.route.basicsc40gsunwed

// void in java
// Unit in java
// ; between statements in same line
fun main() {
    add(50, 30)
    add(80, 40)
    // var     or     val
    var num = 40
    num = 80

    // final int num2 = 20
    // final
    val num2 = 20
//    num2 = 80
    var p = Person(1, "Mohamed")                      //Person("")
    print(p.name)
    // Non Nullable Person
    var p2: Person? = null     // ?     Nullable Types
    // p2   object or null
    print(p2?.name)            // ?.    Conditional Access

    if (p2 != null)
        print(p2.name)
    else
        print(null)

    // Null Pointer Exception

    /*   Non-Null Data Types null X     Nullable Data Types
            Int                             Int?          = 8  or null
            Double                          Double?
           String                            String?
           Person                           Person
     */
    val department: Department? = Department(p)
    // get the length of the manager's name of the department
    // Ahmed
    // 5
    // Runtime
    // Null Pointer Exception
//    if (department != null && department.manager != null && department.manager.name != null)
//        print(department.manager.name.length)
//    else
//        print(null)
    println(department?.manager?.name?.length)
    val name: String =
        department?.manager?.name ?: "Unknown"        // ?: Elvis operator    Default Value
//                                                    // !! Assertion Not Null
    println(department!!.manager!!.name!!.length) // null
    println(department.manager!!.name)



    p.age = 15
    println(p.age)
    p.framework = "Android"
    print(p.framework)

    add(num1 = 80, num3 = 60, num2 = 40) // Readability
    add(50)
    add(80, 30)
    add(62, 90, num4 = 8)
}

class Department(var manager: Person?)

//
class Person(var id: Int, var name: String?) {
    var age: Int = 0
        set(value) {

            field = value + 8
        }
        get() {
            return 2024 - field
        }
    var framework: String = ""
        set(value) {
            field = value + " Engineer"
        }
        get
}


// Secondary Constructor
// Primary and Secondary Constructor
// null Safety
// By Default  => final
// Inherit
open class Parent {
    // final
    open fun doSomeWork() {
        print("Work Done")
    }
}

class Child : Parent() {
    override fun doSomeWork() {
        print("Work Done From Child ")
    }
}


// Declare Parameters
// Default Parameters
fun add(num1: Int, num2: Int = 0, num3: Int = 0, num4: Int = 0): Int {
    return num1 + num2 + num3 + num4
}


