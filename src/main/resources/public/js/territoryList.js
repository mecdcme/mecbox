var _ctx = $("meta[name='ctx']").attr("content");


var codiceRegione;
var codiceProvincia;

$(document).ready(function () {
    setMenuActive("territory-list");
    $('.territory').hide();
    $('.group-provincia').hide();
    renderRegione();
    
    $('#select-regione').change(function (event) {
        codiceRegione = $('#select-regione').val();
        if (codiceRegione !== "0"){
            //var codiceRegione = $('#select-regione option:selected').val();
            $(".group-provincia").show();
            renderProvincia(codiceRegione);
        }else{
            $(".group-provincia").hide();
        }
    });
     $('#select-provincia').change(function (event) {
        codiceProvincia = $('#select-provincia').val();
        renderComune(codiceRegione,codiceProvincia);
    });

});
function renderRegione() {
    var arrRegione = [];    

    $.getJSON(_ctx + "/territory/regione", function (json) {
        console.log("success");
    })
            .done(function (json) {
                console.log("second success");
            })
            .fail(function (json) {
                console.log("error");
            })
            .always(function (json) {
                console.log("complete");
                 addItem(0, "...", 'regione');
                $.each(json, function (i, obj) {
                    arrRegione.push([]);
                    arrRegione[i][0] = obj.regione;
                    arrRegione[i][1] = obj.codReg;
                    addItem(obj.codReg, obj.regione, 'regione');
                });
                $('.loading').hide();               
                $('.territory').animate(
                        {queue: false, duration: 500}
                ).fadeIn('clip', '', 500, callBackShow);

                var defBtns = [{
                        extend: 'csvHtml5',
                        filename: 'regione',
                        title: 'regione',
                        exportOptions: {columns: [0, 1]}
                    }, {
                        extend: 'excelHtml5',
                        filename: 'regione',
                        title: 'regione',
                        exportOptions: {columns: [0, 1]}
                    }, {
                        extend: 'pdfHtml5',
                        filename: 'regione',
                        title: 'regione',
                        exportOptions: {columns: [0, 1]}
                }];
                var defCols = [
                    {'title': 'Regione'},
                    {'title': 'Codice Regione', 'className': 'numeric'}
                ];
                renderTable("territorylist", defBtns, defCols, arrRegione);
            });
}
function renderProvincia(codiceRegione) {

    var arrProvincia = [];
    $(".opt-provincia").remove();   
    $.getJSON(_ctx + "/territory/regione/" + parseInt(codiceRegione) + "/provincia", function (json) {
        console.log("success");
    })
            .done(function (json) {
                console.log("second success");
            })
            .fail(function (json) {
                console.log("error");
            })
            .always(function (json) {
                console.log("complete");
                addItem(0, "...", 'provincia');
                $.each(json, function (i, obj) {

                    arrProvincia.push([]);
                    arrProvincia[i][0] = obj.provincia;
                    arrProvincia[i][1] = obj.codPro;

                    addItem(obj.codPro, obj.provincia, 'provincia');

                });
                $('.loading').hide();
                $('.territory').animate(
                        {queue: false, duration: 500}
                ).fadeIn('clip', '', 500, callBackShow);

                var defBtns = [{
                        extend: 'csvHtml5',
                        filename: 'provincia',
                        title: 'provincia',
                        exportOptions: {columns: [0, 1]}
                    }, {
                        extend: 'excelHtml5',
                        filename: 'provincia',
                        title: 'provincia',
                        exportOptions: {columns: [0, 1]}
                    }, {
                        extend: 'pdfHtml5',
                        filename: 'provincia',
                        title: 'provincia',
                        exportOptions: {columns: [0, 1]}
                }];
                var defCols = [
                    {'title': 'Provincia'},
                    {'title': 'Codice Provincia',  'className': 'numeric'}
                ];
                renderTable("territorylist", defBtns, defCols, arrProvincia);
            });

}
function renderComune(codiceRegione,codiceProvincia) {

    var arrComune = [];

    $.getJSON(_ctx + "/territory/regione/" + parseInt(codiceRegione) + "/provincia/"+ parseInt(codiceProvincia), function (json) {
        console.log("success");
    })
            .done(function (json) {
                console.log("second success");
            })
            .fail(function (json) {
                console.log("error");
            })
            .always(function (json) {
                console.log("complete");
                
                $.each(json, function (i, obj) {

                    arrComune.push([]);
                    arrComune[i][0] = obj.comune;
                    arrComune[i][1] = obj.codCom;

                });
                $('.loading').hide();
                $('.territory').animate(
                        {queue: false, duration: 500}
                ).fadeIn('clip', '', 500, callBackShow);

                var defBtns = [{
                        extend: 'csvHtml5',
                        filename: 'comune',
                        title: 'comune',
                        exportOptions: {columns: [0, 1]}
                    },{
                        extend: 'excelHtml5',
                        filename: 'comune',
                        title: 'comune',
                        exportOptions: {columns: [0, 1]}
                    }, {
                        extend: 'pdfHtml5',
                        filename: 'comune',
                        title: 'comune',
                        exportOptions: {columns: [0, 1]}
                }];
                var defCols = [
                    {'title': 'Comune'},
                    {'title': 'Codice Comune', 'className': 'numeric'}
                ];
                //$("#territorylistcontainer").append('<table id="territorylist" class="table table-striped" cellspacing="0" width="100%"></table>');
                renderTable("territorylist", defBtns, defCols, arrComune);
            });

}
function addItem(newItemVal, newItemDesc,id) {
    
    var disabled = "disabled selected";
    var textDisabled = "";
    
    if (newItemVal==0){
        textDisabled = disabled;
    }
    $('#select-' + id).append('<option '+ textDisabled +' class="opt-'+id+'" value="' + newItemVal + '">' + newItemDesc + '</option>');
    
}
;

function callBackHide() {
    setTimeout(function () {
        $("#center").fadeOut();
    }, 1000);
}
;
function callBackShow() {
    setTimeout(function () {
        $("#center").fadeIn();
    }, 1000);
}
;

	