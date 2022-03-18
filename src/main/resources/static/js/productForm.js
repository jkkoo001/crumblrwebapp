/*const productList = [];

function addProduct() {

    const name = document.querySelector("#productName").value;
    const category = document.querySelector("#category").value;
    const price = document.querySelector("#price").value;
    const description = document.querySelector("#description").value;
    const image = document.querySelector("#formFileLg").value;


    const productDetails = {
        name: name,
        category: category,
        price: price,
        description: description,
        image: image,

    }

    productList.push(productDetails);
    console.log(productList);

    alert("Product Added !");

} //End of addProduct function
*/

//fetch from category table


const productsControl = new ProductsController();
var storeImage = ""

//When user clicks on 'Save Item', calls API to add items to the database
//Add an 'onsubmit' event listener for productform to add a product
newItemForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();
    // Select the inputs
    const newItemNameInput = document.querySelector('#newItemNameInput');
    const newItemDescription = document.querySelector('#newItemDescription');
    const newItemImageUrl = document.querySelector('#newItemImageFile');
    const newItemPrice = document.querySelector('#newItemPrice');
    const newItemCategory = document.querySelector('#newItemCategory');


    /*
        Do the Validation code here
    */

    // Get the values of the inputs - variable names to be same as MySQL columns
    const name = newItemNameInput.value;
    const description = newItemDescription.value;

    // For HTML5 spec - a file uploaded to the browser should not reveal the real local
    // path from the user machine based on security. Browser will append a fakepath
//    (C:\fakepath\t-shirt_new.jpg) to the path for the file information
    const imageUrl = newItemImageUrl.value.replace("C:\\fakepath\\", "");

    const price = newItemPrice.value;
    const category_id = newItemCategory.value;
    //console.log(category_id);


    // Clear the form
    newItemNameInput.value = '';
    newItemCategory.value = '';
    newItemPrice.value = '';
    newItemDescription.value = '';
    newItemImageUrl.value = '';



    // Add the task to the task manager
    productsControl.addItem(name, description, imageUrl, price, category_id, storeImage);

});

// select file input
const input = document.querySelector('#newItemImageFile');

// add event listener
input.addEventListener('change', () => {
    storeImage = input.files[0];
});




