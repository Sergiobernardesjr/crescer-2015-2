//defaults comparação
function isNumber(valor){
  return typeof valor === 'number' ? true : false;
};

function isFunction(fn){
  return typeof fn === 'function' ? true : false;
};

//EX: 1
function daisyGame(petalas){
  if(isNumber(petalas)){
    return 'Love me' + (petalas%2 === 0 ? ' not' : '');
  };
};

//EX: 2
function maiorTexto(texto){
  for (var i = 0, posicao = 0, len = texto.length; i < len;i++){
    if(texto[i].length > texto[posicao].length){
      posicao = i;
    };
  };
  console.log('Indice do maior texto: ', posicao, ' maior texto: ', texto[posicao]);
};

//EX: 3
//instrutores=["Bernardo","Ben-hur","Dudu","Everton","André","Fabricio"];
function instrutor(nomes){
  console.log('Olá querido instrutor: '+ nomes);
};

function imprime(nomes,fn) {
  if (isFunction(fn)){
    nomes.forEach(fn);
  };
};

//EX: 4
function sequenciaFibonacci (n){
  if(n === 1 || n === 2) return 1;

  return sequenciaFibonacci(n-1) + sequenciaFibonacci(n-2);
};

function fiboSum(n){
  return sequenciaFibonacci(n+2)-1;
};

//EX: 6
function queroCafe(mascada, precos){
  if(isNumber(mascada)){
    precos
    .filter(function(elem){
      return precos <= mascada
    })
    .sort(function(elem1, elem2){
      return elem1 > elem2;
    });
    return precos.join(', ');
  };
};
