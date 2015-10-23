String.prototype.palindromo = function(){
  return this.toString().toUpperCase() === this.split('').reverse().join('').toString().toUpperCase();
};
