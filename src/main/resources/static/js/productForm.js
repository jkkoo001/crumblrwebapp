const productList = [];

function addProduct() {

    const name = document.querySelector("#productName").value;
    const category = document.querySelector("#category").value;
    const description = document.querySelector("#description").value;
    const image = document.querySelector("#formFileLg").value;
    const price = document.querySelector("#price").value;

    const productDetails = {
        name: name,
        category:category,
        description: description,
        image: image,
        price: price,
    }

    productList.push(productDetails);
    console.log(productList);

    alert("Product Added !");

} //End of addProduct function


///////////


//Step: 3
//
//Add the codes in the productForm.js” using FormData to fetch the form values and pass the values to the backend for processing.

//fetch from category table


const productsControl = new ProductsController();
var storeImage = ""

//When user clicks on 'Save Item', calls API to add items to the database
//Add an 'onsubmit' event listener for productform to add a product
newItemForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();
    // Select the inputs
    const newItemNameInput = document.querySelector('#productName');
    const newItemDescription = document.querySelector('#description');
    const newItemImageUrl = document.querySelector('#formFileLg');
    const newItemPrice = document.querySelector('#price');
    const newItemCategory = document.querySelector('#category');

    /*
        Do the Validation code here
    */

    // Get the values of the inputs - variable names to be same as MySQL columns
    const name = newItemNameInput.value;
    const description = newItemDescription.value;
    // For HTML5 spec - a file uploaded to the browser should not reveal the real local
    // path from the user machine based on security. Browser will append a fakepath
//    (C:\fakepath\t-shirt_new.jpg) to the path for the file information

    console.log(newItemImageUrl.value);  // reflect the path of the image that uploaded
    const imageUrl = newItemImageUrl.value.replace("C:\\fakepath\\", "");
    // img url = t-shirt_new.jpg
    const category = newItemCategory.value;
    const price = newItemPrice.value;

    // Clear the form
    newItemNameInput.value = '';
    newItemDescription.value = '';
    newItemImageUrl.value = '';
    newItemCategory.value = '';
    newItemPrice.value = '';

    // Add the task to the task manager
    productsControl.addItem(name, description, imageUrl,category, price, storeImage);

});

// select file input
const input = document.querySelector('#formFileLg');

// add event listener
input.addEventListener('change', () => {
    storeImage = input.files[0];
});




