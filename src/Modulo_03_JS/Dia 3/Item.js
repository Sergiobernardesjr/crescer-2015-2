function Item (sku, descricao, quantidade, valorUnitario){
  this.sku = sku;
  this.descricao = descricao;
  this.quantidade = quantidade;
  this.valorUnitario = valorUnitario;
};

Item.prototype.subTotal = function(sku){
  return sku === sku ? (this.quantidade * this.valorUnitario) : alert("Item inexistente!");
};
