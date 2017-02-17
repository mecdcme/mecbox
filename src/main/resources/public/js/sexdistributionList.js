var _ctx = $("meta[name='ctx']").attr("content");

var arrLabel = [];
var arrDataMale = [];
var arrDataFemale = [];
var arrColor = [];


$(document).ready(function () {

    setMenuActive("sexdistribution-list");
    $.getJSON(_ctx + "/sexdistribution/restlist", function (json) {

        var startFrom = 55;
        var individualsTotal = 0;
        $.each(json, function (i, obj) {
            arrLabel.push(obj.range);
            arrDataMale.push(obj.male);
            arrDataFemale.push(obj.female);
            

   
        });
        var configBar = {

            type: 'bar',

            data: {
                labels: arrLabel,
                datasets: [
                {
                    data: arrDataMale,
                    backgroundColor: color[8][2], //coral
                    label: 'Male'
                },{
                    data: arrDataFemale,
                    backgroundColor: color[32][2], //gold
                    label: 'Female'
                }],
            },
            options: {
                responsive: true,
                legend: {
                    position: 'top'
                },
                title: {
                    display: false,
                    text: 'SEX/DISTRIBUTION'
                },

                animation: {
                    animateScale: true,
                    animateRotate: true
                }
            }
         };

         var myChartBar = document.getElementById("bar-chart-area").getContext("2d");
         var myBar = new Chart(myChartBar, configBar);

    });
});