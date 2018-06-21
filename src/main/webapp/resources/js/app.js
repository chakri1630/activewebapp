$(document).ready(function() {
    console.log( "ready!" );
    
    $('#customerInfo').click(function(){
    	
    	$.ajax({
    		   url: 'customerInfo',
    		   error: function() {
    		      $('#info').html('<p>An error has occurred</p>');
    		   },
    		   dataType: 'json',
    		   success: function(data) {
    			   $('#info').innerHTML = 'Customer Info is...'+JSON.stringify(data);
    		   },
    		   type: 'POST'
    		});
    	
    });
    
    $("#orderInfo").click(function(){
    	$.get('orderInfo');
    });
    
    
});