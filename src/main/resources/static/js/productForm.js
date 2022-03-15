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

