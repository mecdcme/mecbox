var _ctx = $("meta[name='ctx']").attr("content");


$(document).ready(function () {
    setMenuActive("household-list");
   $("#householdlist").DataTable({
        
        drawCallback: function () {
               $('.household').animate(
                        {queue: false, duration: 500}
                ).fadeIn('clip', '', 500, callBackShow);
                $(".loading").hide();                
         },        
        dom: "<'row'<'col-sm-6'B><'col-sm-6'f>>" +
                "<'row'<'col-sm-12'tr>>" +
                "<'row'<'col-sm-5'i><'col-sm-7'p>>",
        responsive: true,
        lengthChange: false,
        pageLength: 10,
        deferRender: true,
        buttons: [{
                extend: 'csvHtml5',
                filename: 'household',
                title: 'household'
                
            }, {
                extend: 'excelHtml5',
                filename: 'household',
                title: 'household'
                
            }, {
                extend: 'pdfHtml5',
                filename: 'household',
                title: 'household'                
        }],                 
        columnDefs: [
            {targets: [1, 2, 3, 4, 5, 6, 7, 8, 9], render: $.fn.dataTable.render.number(',', '.', 0), 'className': 'numeric'}
        ]
        
    });
  
    
});