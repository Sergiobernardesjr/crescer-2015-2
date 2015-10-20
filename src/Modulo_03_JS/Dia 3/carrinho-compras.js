function Item (sku, descricao, quantidade, valorUnitario){
  this.sku = sku;
  this.descricao = descricao;
  this.quantidade = quantidade;
  this.valorUnitario = valorUnitario;
};

function Carrinho (){
  this.itens = new Array();
};

Carrinho.prototype.adicionarItem = function(item){
  this.itens.push(item);
};

Carrinho.prototype.procurarItemPorSku = function(sku){
  var indice = 0;
  var itemSku = this.itens.map(function(elem){
    return elem.sku;
  });
  indice = itemSku.indexOf(sku);
  return indice
};

Carrinho.prototype.removerItem = function(sku, quantidade){
  var itemASerRemovido = carrinho.procurarItemPorSku(sku);
  this.itens.splice(itemASerRemovido, quantidade);
}
