<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="bootstrap/js/chart.js" type="text/javascript"></script>
<title>Chart.js</title>
</head>
<body>
<h1>Chart.js</h1>
<h4>Comparacion de navegadores</h4>
<canvas id="myChart"></canvas>
<br>
<h4>Gr�fico de barras</h4>
<canvas id="myChart1"></canvas>
<br>
<h4>Gr�fico de l�neas</h4>
<canvas id="myChart2"></canvas>
<br>
<script src="chart.js"></script>
<script>
var ctx = document.getElementById('myChart').getContext('2d');
var chart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        datasets: [{
            label: 'Ingresos',
            backgroundColor: '#42a5f5',
            borderColor: 'gray',
            data: [7, 8, 5, 2, 8, 10, 7,-7,4,9,-8,5]
        },{
            label: 'Gastos',
            backgroundColor: '#ffab91',
            borderColor: 'yellow',
            data: [5, -8, 10, 3,-7,6,8,-2,-6,9,-7,2]
        }		
		]},
    options: {responsive: true}
});
var ctx1 = document.getElementById('myChart1').getContext('2d');
var chart = new Chart(ctx1, {
    type: 'line',
    data: {
        labels: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        datasets: [{
            label: 'Ganancias',
            backgroundColor: '#42a5f5',
            borderColor: 'gray',
            data: [7, 8, 5, 2, 8, 10, 7,-7,4,9,-8,5]
        }		
		]},
    options: {}
});
var ctx2 = document.getElementById('myChart2').getContext('2d');
var chart = new Chart(ctx2, {
    type: 'doughnut',
    data: 	
	{
				datasets: [{
					 data: [60,18,10, 8, 4],
					backgroundColor: ['#42a5f5', 'red', 'green','blue','violet'],
					label: 'Comparacion de navegadores'
				}],
				labels: [
					'Google Chrome',
					'Safari',
					'Edge',
					'Firefox',
					'Opera'
				]},
    options: {}
});
</script>
</body>
</html>    