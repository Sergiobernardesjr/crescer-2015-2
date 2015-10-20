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

//EX: 5
function excelis(referencia){
  referencia = referencia.toUpperCase();
  for (var i=0, soma=0, len=referencia.length; i < len; i++){
    soma = soma * 26 + (referencia.charCodeAt(i) - 64);
  };
  return soma;
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

// lista de exercícios 2
var clubes = [
  {
    nome: 'Arsenal',
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Manchester United',
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];
// EXRCICIO 1:
//1.A
function ordenaPorNacionais(clubes){
  clubes.sort(function(elem1, elem2){
    return elem1.titulos[0].qtd < elem2.titulos[0].qtd;
  })
};

//1.B
function ordenaPorContinentais(clubes){
  clubes.sort(function(elem1, elem2){
    return elem1.titulos[1].qtd < elem2.titulos[1].qtd;
  })
};

//1.C
function ordenaPorMundiais(clubes){
  clubes.sort(function(elem1, elem2){
    return elem1.titulos[2].qtd < elem2.titulos[2].qtd;
  })
};

function somarPorNacionais(clubes){
  var somatorio = 0;
    for (var i=0, len=clubes.length; i<len; i++){
      somatorio += clubes[i].titulos[0].qtd;
    }
    return somatorio;
};

function somarPorContinentais(clubes){
  var somatorio = 0;
    for (var i=0, len=clubes.length; i<len; i++){
      somatorio += clubes[i].titulos[1].qtd;
    }
    return somatorio;
};

function somarPorMundiais(clubes){
  var somatorio = 0;
    for (var i=0, len=clubes.length; i<len; i++){
      somatorio += clubes[i].titulos[2].qtd;
    }
    return somatorio;
};

function apenasOsMelhores(clubes){
  return clubes.filter( function(elem) { elem.titulos[0].qtd >= 18});
};
