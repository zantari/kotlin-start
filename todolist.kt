

//Dodać zadanie do listy.
//
//Wyświetlić wszystkie zadania.
//
//Usunąć wybrane zadanie po numerze.
//
//Zakończyć program.

class Task(
    var name:String,
    var isDone: Boolean
)


fun main(){
    val tasks = mutableListOf<Task>()
    tasks.add(Task("Testowy task", false))

    while(true) {
        println("=========TO DO LIST=========")
        println("|   1. Add task [a]        |")
        println("|   2. Edit task [e]       |")
        println("|   3. Show all tasks [s]  |")
        println("|   4. Delete a task [d]   |")
        println("|   5. End program [x]     |")
        println("============================")
        print("choose an option:")

        val option = readln()

        when (option) {
            "1", "a", "A" -> {
                println("==========ADD TASK==========")
                while(true) {
                    print("Name of the task: ")
                    val name = readln()
                    print("Is it done? [y/n]")
                    val isDone = readln()

                    if(name.trim() != "" && (isDone.lowercase() =="y" || isDone.lowercase() == "n")){
                        var isDoneBool = true

                        if(isDone.lowercase() == "n"){
                            isDoneBool = false
                        }
                        tasks.add(Task(name, isDoneBool))

                        println("Added task ${name}")
                        print("press enter.")
                        readln()

                        break
                    }
                    else{
                        println("wrong data try again")
                    }




                }
            }

            "2", "e", "E" -> {
                if (tasks.isEmpty()){
                    println("you dont have any tasks")
                    print("press enter... ")
                    readln()
                    continue
                }
                println("=========EDIT TASK==========")
                println("your tasks: ")
                var i:Int = 0

                tasks.forEach { task -> val status = if(task.isDone) "yes" else "no"
                                    i++
                                    println("id: $i, name: ${task.name}, done?: $status")
                                }
                println("which one do you want to edit? (id)")

                while(true){
                    val id = readln().toIntOrNull()
                    if(id == null || id>tasks.size || id<1 ){
                        println("try again")
                    }
                    else {


                        while(true) {
                            println("=========EDITING ${tasks[id-1].name}=========")
                            println("what do you want to edit?")
                            println("1. Name of the task [n]")
                            println("2. Status of the task [s]")
                            println("3. Exit edit mode [x]")
                            val whatToEdit = readln()
                                when(whatToEdit){
                                    "1", "n", "N" -> {
                                        println("===== ENTER THE NEW NAME OF THE TASK - ${tasks[id-1].name} =====")

                                        while(true) {
                                            val newName = readln()

                                            if(newName.trim() == ""){
                                                println("wrong name try again")
                                            }
                                            else{
                                                tasks[id-1].name = newName
                                                println("Done. ")
                                                print("press enter")
                                                readln()
                                                break


                                                }



                                            }

                                        }

                                    "2", "s", "S" -> {
                                        println("enter the new status for ${tasks[id-1].name}")
                                        println("Current status: ${if (tasks[id-1].isDone) "done" else "not done"}")
                                        println("do you want to change the status? [y/n]")
                                        while(true) {
                                            val changeStatus = readln()

                                                if(changeStatus == "y"){
                                                    tasks[id-1].isDone = !tasks[id-1].isDone
                                                    println("changed successfully, current status is: ${tasks[id-1].isDone}")
                                                    println("press enter...")
                                                    readln()
                                                    break
                                                }
                                                else if(changeStatus == "n"){
                                                    println("status is still ${tasks[id-1].isDone}")
                                                    println("press enter...")
                                                    readln()
                                                    break
                                                }
                                                else{
                                                    println("error, you need to type y - to change or n - to keep")

                                                }


                                        }




                                    }

                                    "3", "x", "X" ->{
                                            break
                                    }
                                    else -> {
                                        println("error, try again")
                                    }
                                }

                        }


                        print("press enter... ")
                        readln()
                        break
                    }
                }

            }

            "3", "s", "S" -> {
                if (tasks.isEmpty()){
                    println("you dont have any tasks")
                    print("press enter... ")
                    readln()
                    continue
                }
                println("==========ALL TASKS=========")
                tasks.forEach { task -> val status = if(task.isDone) "yes" else "no"
                    println("name: ${task.name}, done?: $status" )}

                print("press enter.")
                readln()

            }

            "4", "d", "D" -> {




                while(true) {
                    if (tasks.isEmpty()){
                        println("you dont have any tasks")
                        print("press enter... ")
                        readln()
                        break

                    }

                    println("=========DELETE TASK==========")
                    println("your tasks: ")
                    var i:Int = 0

                    tasks.forEach { task -> val status = if(task.isDone) "yes" else "no"
                        i++
                        println("id: $i, name: ${task.name}, done?: $status")
                    }
                    println("which one do you want to delete? (id) (press 0 to exit)")

                    val id = readln().toIntOrNull()

                    if(id == 0){
                        break
                    }
                    else if (id == null || id > tasks.size || id < 1) {
                        println("try again")
                    }
                    else{
                        println("delete ${tasks[id-1].name}? [y/n]")
                        while(true) {
                            val changeStatus = readln()

                            if(changeStatus == "y"){
                                tasks.removeAt(id-1)
                                println("successfully deleted")
                                println("press enter...")
                                readln()
                                break

                            }
                            else if(changeStatus == "n"){
                                println("${tasks[id-1].name} is not deleted")
                                println("press enter...")
                                readln()
                                break
                            }
                            else{
                                println("error, you need to type y - to delete or n - to keep")

                            }
                            break

                    }
                        break
                }
            }
            }




            "5", "x", "X" -> {
                println("closing program...")
                break
            }

            else -> {
                println("wrong option")
                println("press enter...")
                readln()
            }
        }


    }
}
