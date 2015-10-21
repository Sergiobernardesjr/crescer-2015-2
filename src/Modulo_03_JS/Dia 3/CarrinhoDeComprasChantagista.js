CarrinhoDeComprasChantagista.prototype = Object.create(CarrinhoDeCompras.prototype);

function CarrinhoDeComprasChantagista (){
  CarrinhoDeCompras.apply(this, arguments);
}

CarrinhoDeComprasChantagista.prototype.forcarCompra = function(){
  if (!this.intervalo){
    this.intervalo = setInterval(function(){
      this.itens.forEach(function(elem){
        elem.valorUnitario += elem.valorUnitario * 0.1;
      });
    }.bind(this), 5000);
  }
};

CarrinhoDeComprasChantagista.prototype.concluirPedido = function(){
  clearInterval(this.intervalo);
  delete this.intervalo;
};
