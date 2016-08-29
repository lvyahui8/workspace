<!DOCTYPE html>
<html lang="en">
 	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">

    	<title>{{ CNF_APPNAME }}</title>
		{{ HTML::style('sximo/css/bootstrap.min.css')}}
		{{ HTML::style('sximo/css/sximo.css')}}
		{{ HTML::style('sximo/css/icons.min.css')}}

	
  	</head>

<body class="full-width page-condensed">
	<div class="page-container">
		
		<div class="error-wrapper text-center">
		  <h1>{{ $code }} </h1>
		  <h6>{{ $note }}</h6>
		  <!-- Error content -->
		  <div class="error-content">

		    <div class="row" style="text-align:center;">
		     <a class="btn btn-warning btn-block" href="javascript:history.go(-1)">Back to Previous page</a> 
		    </div>
		  </div>
		  <!-- /error content -->
		</div>
			
	</div>
</body>

</html>

