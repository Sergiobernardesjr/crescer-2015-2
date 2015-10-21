function CarrinhoDeCompras (){
  this.itens = new Array();
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
      return acumulador += (elem.quantidade * elem.valorUnitario)
    },0)
    desconto = this.sortearDesconto() ? 0.9 : 1;
    return totalDosItensNoCarrinho * desconto;
};

CarrinhoDeCompras.prototype.sortearDesconto = function(){
  return Math.random() < 0.4;
}
