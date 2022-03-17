


    const createHTMLList = (index, name, imageURL,price) =>
    `
    <div class="col-lg-4">
    <div class="card mx-auto mb-5" style="width: 20rem;">
        <img src=${imageURL} class="card-img-top"
            alt="${name}" height="300" style="object-fit: cover;">
        <div class="card-body">
            <h5 class="card-title">${name}</h5>
            <h5 class="card-text">$${price}</p>
            <a id="${index}" href="#" class="btn btn-primary" data-toggle="modal" data-target="#productModal">Details</a>
        </div>
    </div>
    </div>

    `;

     function displayProductDetails(item)
        {
            document.querySelector("#modalName").innerText = item.name;
            document.querySelector("#modalImg").src = item.imageUrl;
            document.querySelector("#modalDescription").innerText = item.description;
            document.querySelector("#modalPrice").innerText = item.price;


        }

///////
class ProductsController
{
    constructor()
    {
        this._items = [];       //create an array to store the details of product items
    }

    //method to add the items into the array

       addItem(name, description, imageUrl, price, category, imageObject)
           {
           // default is GET
           // fetch POST HTTP method to send the data to the backend via the API
               var productController = this;
               const formData = new FormData();
               formData.append('name', name);
               formData.append('description', description);
               formData.append('imageUrl', imageUrl);
               formData.append('price', price);
               formData.append('category', category);
               formData.append('imagefile',imageObject);

              fetch('http://localhost:8080/item/add', {
                    method: 'POST',
                    body: formData
                    })
                    .then(function(response) {
                        console.log(response.status); // Will show you the status
                        if (response.ok) {
                            alert("Successfully Added Product!")
                        }
                    })
                    .catch((error) => {
                        console.error('Error:', error);
                        alert("Error adding item to Product")
                    });
           }



    displayItem()
    {
        //fetch the items from the database using the API
           var productController = this;
           productController._item =[];

        //fetch data from database using the REST API endpoint from Spring Boot
       // IP address 192.168.86.121
//        fetch('http://192.168.86.121:8080/item/all')
            fetch('http://localhost:8080/item/all')
//           fetch('http://127.0.0.1:8080/item/all')
               .then((resp) => resp.json())
               .then(function(data) {
                   console.log("2. receive data")
                   console.log(data);
                   data.forEach(function (item, index) {
                        // create object
                       const itemObj = {
                           id: item.id,
                           name: item.name,
                           description: item.description,
                           imageUrl: item.imageUrl,
                           price: item.price,
                           category: item.category,
                      };
                      // push to array of objects
                       productController._items.push(itemObj);
                 });

                 productController.renderProductPage();

               })
               .catch(function(error) {
                   console.log(error);
               });


    }



    renderProductPage()
    {
        var productHTMLList = [];

        for (var i=0; i<this._items.length; i++)
        {
            const item = this._items[i];            //assign the individual item to the variable

            const productHTML = createHTMLList(i, item.name, item.imageUrl, item.price);

            productHTMLList.push(productHTML);
        }

        //Join all the elements/items in my productHTMLList array into one string, and seperate by a break
        const pHTML = productHTMLList.join('\n');
        document.querySelector('#row').innerHTML = pHTML;


        //addEventListener - click
        for (var i=0; i<this._items.length; i++)
        {
            const item = this._items[i];
            document.getElementById(i).addEventListener("click", function() { displayProductDetails(item);} );
        }


    }


}   //End of ProductsController class







