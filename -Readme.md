This project in this repository is the second on the provided list. However, rather than using contact information, grocery list information is used. A user can add, remove and update an existing item. All of the changes are reflected in a data.txt file. The main class is named "Main.java"

MVC pattern has been used in the project. There are four controllers (Home, AddController, RemoveController and UpdateController). Each of it are associated with a screen which acts as a view. Views are the .fxml files and there are 4 of them as well. Lastly, a model is created which stores the id, name, quantity and price information of any item. This is how the MVC pattern gets implemented.

The home screen has three buttons for add, remove and update functionality. Add screen has buttons and labels. On the other hand, remove and update screens have a listview. Clicking on any item on the list, removes it in the remove screen while in update screen's listview, a new screen is opened when an item is clicked. From there, the item can be modified as required. 

Both the listview and lambda functions have been implemented and are in the AddController class. The inner class acts as a utility class which has a function "createNumericOnlyFields" that allows the fields to have only numeric data in id, price and quantity fields. This function uses lambda functions for this purpose. 

**The UI has been particularly emphasised. The home screen has an attractive background image and all other screens have a back button. The UX is functional and smooth as well.**

**Also, added a video of showing how the project works.**
