function Item (option){
  option = option || {};
  this.sku = option.sku;
  this.descricao = option.descricao;
  this.quantidade = option.quantidade;
  this.valorUnitario = option.valorUnitario;
};

Item.prototype.subTotal = function(){
  subTotal = this.quantidade * this.valorUnitario;
  return subTotal;
};
