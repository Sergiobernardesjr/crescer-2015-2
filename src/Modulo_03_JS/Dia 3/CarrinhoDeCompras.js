function CarrinhoDeCompras (itens){
  this.itens = itens || [];
};

CarrinhoDeCompras.prototype.adicionarItem = function(item){
  this.itens.push(item);
};

CarrinhoDeCompras.prototype.procurarItemPorSku = function(sku){
  var itemSku = this.itens.filter(function(elem){
    return elem.sku === sku;
  });
  return itemSku;
};

CarrinhoDeCompras.prototype.removerItem = function(sku){
  this.itens = this.itens.filter(function(elem){
    return elem.sku !== sku;
  })
};

CarrinhoDeCompras.prototype.atualizarQuantidade = function(sku, quantidade){
  var itemASerAtualizado = this.procurarItemPorSku(sku);
  this.itens[itemASerAtualizado].quantidade = quantidade;
};

CarrinhoDeCompras.prototype.totalDoCarrinho = function(){
  var desconto = 0;
  var totalDosItensNoCarrinho = this.itens
    .reduce (function (acumulador,elem){
       return acumulador += elem.subTotal();
    },0);

    desconto = this.sortearDesconto() ? 0.9 : 1;

    return totalDosItensNoCarrinho * desconto;
};

CarrinhoDeCompras.prototype.sortearDesconto = function(){
  return Math.random() < 0.4;
};


CarrinhoDeCompras.prototype.forcarCompra = function(){
  if (!this.intervalo){
    this.intervalo = setInterval(function(){
      this.itens.forEach(function(elem){
        console.log('Antes: ' + elem.valorUnitario);
        elem.valorUnitario += elem.valorUnitario * 0.1;
        console.log('Depois: ' + elem.valorUnitario);
      });
    }.bind(this), 5000);
  }
};

CarrinhoDeCompras.prototype.concluirPedido = function(){
  clearInterval(this.intervalo);
  delete this.intervalo;
};
