import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("I'll to create a Array of Ninjas, enter the size of array: ");
        int sizeOfArrayOfNinjas = scanner.nextInt();
        scanner.nextLine();

        Ninja[] ninjas = new Ninja[sizeOfArrayOfNinjas];
        int amountOfNinjasInArrayOfNinjas = 0;

        System.out.println();

        int chosenMenuItem = 1;
        while (chosenMenuItem != 0) {
            System.out.println(
                """
                    --- MENU ---
                    [1] - Create a new Ninja!
                    [2] - List all ninjas registered in Array.
                    [3] - Delete a ninja registered in Array.
                    [4] - Edit a ninja registered in Array.
                    [0] - Exit of the Program!
                """
            );

            System.out.print("Choose a item of the menu above: ");
            chosenMenuItem = scanner.nextInt();
            scanner.nextLine();

            System.out.println();

            int chosenNinjaIndex;
            switch (chosenMenuItem) {
                case 1:
                    if (amountOfNinjasInArrayOfNinjas == sizeOfArrayOfNinjas) {
                        System.out.println("The Array of Ninjas is full!!");
                        continue;
                    }

                    listArrayOfNinjas(ninjas);

                    while (true) {
                        System.out.print("Choose a index of the Array of Ninjas for create a new Ninja: ");
                        chosenNinjaIndex = scanner.nextInt();
                        scanner.nextLine();

                        if (chosenNinjaIndex < 1 || chosenNinjaIndex > sizeOfArrayOfNinjas) {
                            System.out.printf("The index: %d is not valid! Retry Again!\n", chosenNinjaIndex);
                            continue;
                        }

                        if (ninjas[chosenNinjaIndex-1] != null) {
                            System.out.printf("The index: %d already have a ninjas\n", chosenNinjaIndex);
                            continue;
                        }

                        break;
                    }

                    System.out.printf("Ok, let's go to crete a new ninja in index: %d\n", chosenNinjaIndex);
                    System.out.println();

                    while (true) {
                        System.out.print("What's name of the new Ninja: ");
                        String nameNewNinja = scanner.nextLine();

                        if (nameNewNinja.isEmpty()) {
                            System.out.println("The name of the Ninja can't empty! Retry Again!");
                            System.out.println();
                            continue;
                        }

                        System.out.print("What's age of the new Ninja: ");

                        if (!scanner.hasNextInt()) {
                            System.out.println("You enter a invalid Age for new Ninja, Retry Again!");
                            scanner.nextLine();
                            System.out.println();
                            continue;
                        }

                        int ageNewNinja = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("What's village of the new Ninja: ");
                        String villageNewNinja = scanner.nextLine();

                        if (villageNewNinja.isEmpty()) {
                            System.out.println("The village of the Ninja can't empty! Retry Again!");
                            System.out.println();
                            continue;
                        }

                        Ninja newNinja = new Ninja(nameNewNinja, ageNewNinja, villageNewNinja);
                        ninjas[chosenNinjaIndex-1] = newNinja;
                        System.out.println();

                        break;
                    }

                    System.out.println("A new Ninja has been successfully added!");

                    amountOfNinjasInArrayOfNinjas++;
                    break;

                case 2:
                    if (amountOfNinjasInArrayOfNinjas == 0) {
                        System.out.println("Nothing Ninjas in Array of Ninjas!");
                        System.out.println();
                        continue;
                    }
                    listArrayOfNinjas(ninjas);
                    break;

                case 3:
                    if (amountOfNinjasInArrayOfNinjas == 0) {
                        System.out.println("Nothing Ninjas in Array of Ninjas!");
                        System.out.println();
                        continue;
                    }

                    listArrayOfNinjas(ninjas);

                    while (true) {
                        System.out.print("Choose a index of the Array of Ninjas for delete a Ninja: ");
                        chosenNinjaIndex = scanner.nextInt();
                        scanner.nextLine();

                        if (chosenNinjaIndex < 1 || chosenNinjaIndex > sizeOfArrayOfNinjas) {
                            System.out.printf("The index: %d is not valid! Retry Again!\n", chosenNinjaIndex);
                            continue;
                        }

                        if (ninjas[chosenNinjaIndex-1] == null) {
                            System.out.printf("The index: %d haven't a ninja. Retry Again\n", chosenNinjaIndex);
                            continue;
                        }

                        System.out.printf("Deleting ninja: %s...\n", ninjas[chosenNinjaIndex-1].getName());
                        ninjas[chosenNinjaIndex-1] = null;

                        amountOfNinjasInArrayOfNinjas--;
                        break;
                    }

                    break;

                case 4:
                    if (amountOfNinjasInArrayOfNinjas == 0) {
                        System.out.println("Nothing Ninjas in Array of Ninjas!");
                        System.out.println();
                        continue;
                    }

                    listArrayOfNinjas(ninjas);

                    while (true) {
                        System.out.print("Choose a index of the Array of Ninjas for edit a Ninja: ");
                        chosenNinjaIndex = scanner.nextInt();
                        scanner.nextLine();

                        if (chosenNinjaIndex < 1 || chosenNinjaIndex > sizeOfArrayOfNinjas) {
                            System.out.printf("The index: %d is not valid! Retry Again!\n", chosenNinjaIndex);
                            continue;
                        }

                        if (ninjas[chosenNinjaIndex-1] == null) {
                            System.out.printf("The index: %d haven't a ninja. Retry Again\n", chosenNinjaIndex);
                            continue;
                        }

                        break;
                    }

                    while (true) {
                        System.out.print("What's name of the new Ninja: ");
                        String nameNewNinja = scanner.nextLine();

                        if (nameNewNinja.isEmpty()) {
                            System.out.println("The name of the Ninja can't empty! Retry Again!");
                            System.out.println();
                            continue;
                        }

                        System.out.print("What's age of the new Ninja: ");

                        if (!scanner.hasNextInt()) {
                            System.out.println("You enter a invalid Age for new Ninja, Retry Again!");
                            scanner.nextLine();
                            System.out.println();
                            continue;
                        }

                        int ageNewNinja = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("What's village of the new Ninja: ");
                        String villageNewNinja = scanner.nextLine();

                        if (villageNewNinja.isEmpty()) {
                            System.out.println("The village of the Ninja can't empty! Retry Again!");
                            System.out.println();
                            continue;
                        }

                        Ninja ninjaEdit = ninjas[chosenNinjaIndex-1];
                        ninjaEdit.setName(nameNewNinja);
                        ninjaEdit.setAge(ageNewNinja);
                        ninjaEdit.setVillage(villageNewNinja);
                        System.out.println();

                        break;
                    }
                    break;

                case 0:
                    System.out.println("Bye Bye...");
                    break;

                default:
                    System.out.printf("The item: %d is not valid! Retry Again!\n", chosenMenuItem);
                    break;
            }
        }

        scanner.close();
    }

    public static void listArrayOfNinjas(Ninja[] ninjas) {
        System.out.println("\n--- ARRAY OF NINJAS ---");
        for (int i = 0; i < ninjas.length; i++) {
            if (ninjas[i] == null) {
                System.out.printf("Ninja %d: Empty Place...\n", i+1);
                continue;
            }
            System.out.printf("Ninja %d: %s\n", i+1, ninjas[i].toString());
        }
        System.out.println("--- --------------- ---\n");
    }
}