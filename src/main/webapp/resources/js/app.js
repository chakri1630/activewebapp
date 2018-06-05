$(document).ready(function() {
    console.log( "ready!" );
    
    $('#customerInfo').click(function(){
    	
    	$.ajax({
    		   url: 'customerInfo',
    		   data: {
    		      format: 'json'
    		   },
    		   error: function() {
    		      $('#info').html('<p>An error has occurred</p>');
    		   },
    		   dataType: 'jsonp',
    		   success: function(data) {
    			   $('#info').html('Customer Info is...');
    		   },
    		   type: 'POST'
    		});
    	
    });
    
    
});