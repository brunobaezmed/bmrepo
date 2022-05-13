class Producto {
    constructor(name,price,year){
        this.name = name;
        this.price = price;
        this.year = year;
    }
}
class UI {
    addProduct(product){
        const productList = document.getElementById('product-list');
        const element = document.createElement('div');
        element.innerHTML = ` 
            <div class="card text-center mb-4">
                <div class="card-body">
                    <strong>Producto</strong>: ${product.name}
                    <strong>Precio del producto</strong>: ${product.price}
                    <strong>Año del Producto</strong>: ${product.year}
                    <a href="#" class="btn btn-danger" name="delete">Borrar</a>
                 </div>
            </div>
        `;
        productList.appendChild(element);
    }
    resetearFormulario(){
        document.getElementById('product-form').reset()
    }
    deleteProduct(element){
        if(element.name === 'delete'){
            element.parentElement.parentElement.parentElement.remove();       
            this.showMessage('Producto Eliminado', 'info');
        }

    }
    showMessage(message, cssClass){
       const div = document.createElement('div');
        div.className =   `alert alert-${cssClass} mt-2`;
        div.appendChild(document.createTextNode(message));
        //Mostrando en el DOM
        const container = document.querySelector('.container');
        const app = document.querySelector('#App');
        container.insertBefore(div, app);
        setTimeout(function(){
            document.querySelector('.alert').remove();
        }, 3000);
    }
}
//dom events
document.getElementById('product-form')
    .addEventListener('submit',function(e){
       const name = document.getElementById('name').value;
       const price = document.getElementById('price').value;
       const year = document.getElementById('year').value;
       
       console.log(name,price,year);
       const producto = new Producto( name, price, year);

       const ui = new UI();

       if(name === '' || price === '' || year === ''){
            return ui.showMessage('Complete los campos','danger');
       }
       ui.addProduct(producto);
       ui.resetearFormulario();
       ui.showMessage('Producto agregado','success');
       e.preventDefault();

    })
    document.getElementById('product-list').addEventListener('click',function(e){
        const ui =new UI();
        ui.deleteProduct(e.target);
    })