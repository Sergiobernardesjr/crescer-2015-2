// equivale a extends
ElfoNoturno.prototype = Object.create(Elfo.prototype);

function ElfoNoturno(){
  Elfo.apply(this, arguments);
}
