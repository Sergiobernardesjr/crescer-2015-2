function Item (sku, descricao, quantidade, valorUnitario){
  this.sku = sku;
  this.descricao = descricao;
  this.quantidade = quantidade;
  this.valorUnitario = valorUnitario;
};

function CarrinhoDeCompras (){
  this.itens = new Array();
};

CarrinhoDeCompras.prototype.adicionarItem = function(item){
  this.itens.push(item);
};

CarrinhoDeCompras.prototype.procurarItemPorSku = function(sku){
  var indice = 0;
  var itemSku = this.itens.map(function(elem){
    return elem.sku;
  });
  indice = itemSku.indexOf(sku);
  return indice
};

CarrinhoDeCompras.prototype.removerItem = function(sku, quantidade){
  var itemASerRemovido = this.procurarItemPorSku(sku);
  if (this.itens[itemASerRemovido].quantidade > quantidade){
    this.itens[itemASerRemovido].quantidade -= quantidade;
  }
  else if (this.itens[itemASerRemovido].quantidade === quantidade){
    this.itens.splice(itemASerRemovido, quantidade);
  }
  else {
    alert('Não é permitido remover item com a quantidade menor que existente no carrinho!');
  }

}

CarrinhoDeCompras.prototype.atualizarQuantidade = function(sku, quantidade){
  var itemASerAtualizado = this.procurarItemPorSku(sku);
  this.itens[itemASerAtualizado].quantidade = quantidade;
}
