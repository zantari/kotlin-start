




data class Task(
    val name:String,
    val priority: Int,
    val timeTask: Int

)


fun main(){
    val queue = mutableListOf<Task>()
    var isOn: Boolean = true

    while (isOn) {
        queue.sortByDescending { it.priority }
        println("Choose what do you want to do: ")
        println("1. Add task to queue")
        println("2. Execute a task")
        println("3. Display all tasks")
        println("4. Exit")

        println("type: ")
        var choice = readln().toIntOrNull()

        if(choice == null || choice>4 || choice<1){
            println("please input valid number")
        }

        if(choice == 4){
            isOn = false
        }


        if(choice == 1){
            println("Enter the name of the task: ")
            val name = readln()

            println("enter the priority")
            var priorytet = readln().toIntOrNull()
            while (priorytet == null){
                println("enter the priority")
                priorytet = readln().toIntOrNull()
            }

            println("Enter the execution time (in sec)")
            var czas = readln().toIntOrNull()
            while (czas == null){
                println("Enter the execution time (in sec)")
                czas = readln().toIntOrNull()
            }


            val task = Task(name, priorytet, czas)
            queue.add(task)
            println("added task: ${task.name}")
            readln()
        }

        if(choice == 3){
            if(queue.isEmpty()){
                println("you dont have any tasks yet")
                readln()
            }
            else{
                println("tasks in queue: ")
                queue.forEach { task ->
                    println("${task.name}, priority: ${task.priority}, time: ${task.timeTask}")
                }

                readln()
            }
        }

        if(choice == 2){
            if(queue.isEmpty()){
                println("No tasks to execute.")
                readln()
            }
            else{

                val taskToDo = queue.removeAt(0)
                println("executing a task ${taskToDo.name}...")

                Thread.sleep(taskToDo.timeTask * 1000L)

                println("Done.")
                readln()


            }
        }





    }

    println("closing...")



}
