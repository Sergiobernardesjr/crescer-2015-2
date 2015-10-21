Date.prototype.bissexto = function(){
  var ano = this.getFullYear();
  return (ano % 400 == 0 || (this.ano % 4 == 0 && this.ano %100 != 0));
};
