class Product {

    productItems = [];

    constructor() {}

    addProduct(name, category, description, image, price) {
        const item = {
            name: name,
            category: category,
            description: description,
            image: image,
            price: price,
        };

        this.productItems.push(item);

    }   // end of addProduct()

    displayProduct() {
        console.log(this.productItems);

        let productDetails = "";

        let index = 0;
        let detailsBtnId = "";

        this.productItems.forEach (item => {
            detailsBtnId = "item" + index;

            productDetails += `
            <div class="col-lg-3 col-md-4 col-12 mt-5">
                <div class="card text-center mx-auto" style="width: 15rem;">
                  <img src="${item.image}" class="card-img-top" alt="${item.name}" height="300" style="object-fit: cover;">
                  <div class="card-body">
                    <h5 class="card-title">${item.name}</h5>
                    <h5>$${item.price}</h5>

                    <a id="${detailsBtnId}" href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#productModal">Details</a>
                  </div>
                </div>

            </div>`;
            index++;
        });

        document.querySelector("#row").innerHTML = productDetails;

        index = 0;
        this.productItems.forEach(item => {
            detailsBtnId = "item" + index;

            document.getElementById(detailsBtnId).addEventListener("click", function() {displayItemDetail(item);});

            index++;

        });

    }   // end of displayProduct()
}   // end of class Product


//Start of event handler function
const displayItemDetail = (item) => {
    document.querySelector("#itemName").innerText = item.name;
    document.querySelector("#itemImage").src = item.image;
    document.querySelector("#itemDescription").innerText = item.description;
    document.querySelector("#itemPrice").innerText = item.price;
} //End of event handler function
