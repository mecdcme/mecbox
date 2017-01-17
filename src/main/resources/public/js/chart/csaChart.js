var drawChart = function () {
    var barChart = document.getElementById("chartjs-barchart").getContext("2d");
    var data = [];
    var colors = [{
            fillColor: "#23b7e5",
            strokeColor: "#23b7e5"
        },
        {
            fillColor: "#f44336",
            strokeColor: "#f44336"
        }];
    for (var i = 1; i < arguments.length; i++) {
        data.push({
            fillColor: colors[(i-1)%colors.length].fillColor,
            strokeColor: colors[(i-1)%colors.length].strokeColor,
            data: arguments[i]
        });
    }
    var barData = {
        labels: arguments[0],
        datasets: data
    };

    new Chart(barChart).Bar(barData);

};
