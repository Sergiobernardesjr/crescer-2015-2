String.prototype.palindromo = function(){
  return this.toString() === this.split('').reverse().join('').toString();
};
