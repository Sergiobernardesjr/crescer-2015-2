var clubes = [
  {
    nome: 'Arsenal',
    fundacao: new Date(1886, 0, 1),
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Manchester United',
    fundacao: new Date(1878, 0, 1),
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    fundacao: new Date(1892, 2, 15),
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    fundacao: new Date(1905, 2, 10),
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];

/*UTILIZANDO SOMENTE O REDUCE
  function calcularIdadeMedia(clubes){
  var media = 0;
  var len = clubes.length;
  media = (clubes.reduce(function(acumulador, elem){
    var idade = new Date().getFullYear() - elem.fundacao.getFullYear();
    return acumulador + idade;
  },0)) / len;

  return media;
}*/

// UTILIZANDO O MAP E REDUCE
function calcularIdadeMedia(clubes){
  var len = clubes.length;
  var media = 0;
  var soma = clubes
    .map(function(elem) {
      return new Date().getFullYear() - elem.fundacao.getFullYear()
    })
    .reduce(function(acumulador,elem){
      return acumulador + elem;
    },0);

    return media = soma / len;
};
