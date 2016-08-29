
  <div class="page-content row">
    <!-- Page header -->
    <div class="page-header">
      <div class="page-title">
        <h3> {{ $pageTitle }} <small>{{ $pageNote }}</small></h3>
      </div>
      <ul class="breadcrumb">
        <li><a href="{{ URL::to('dashboard') }}">{{ Lang::get('core.home') }}</a></li>
		<li><a href="{{ URL::to('estates?md='.$filtermd) }}">{{ $pageTitle }}</a></li>
        <li class="active">{{ Lang::get('core.addedit') }} </li>
      </ul>
	  	  
    </div>
 
 	<div class="page-content-wrapper">
		@if(Session::has('message'))	  
			   {{ Session::get('message') }}
		@endif	
		<ul class="parsley-error-list">
			@foreach($errors->all() as $error)
				<li>{{ $error }}</li>
			@endforeach
		</ul>
		 {{ Form::open(array('url'=>'estates/save/'.SiteHelpers::encryptID($row['id']).'?md='.$filtermd.$trackUri, 'class'=>'form-horizontal','files' => true , 'parsley-validate'=>'','novalidate'=>' ')) }}
<div class="col-md-12">
						<fieldset><legend> estates</legend>
									
								  <div class="form-group hidethis " style="display:none;">
									<label for="Id" class=" control-label col-md-4 text-left"> Id </label>
									<div class="col-md-6">
									  {{ Form::text('id', $row['id'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="楼盘名称" class=" control-label col-md-4 text-left"> 楼盘名称 <span class="asterix"> * </span></label>
									<div class="col-md-6">
									  {{ Form::text('name', $row['name'],array('class'=>'form-control', 'placeholder'=>'', 'required'=>'true'  )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="参考均价" class=" control-label col-md-4 text-left"> 参考均价 </label>
									<div class="col-md-6">
									  {{ Form::text('avg_price', $row['avg_price'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="开盘时间" class=" control-label col-md-4 text-left"> 开盘时间 </label>
									<div class="col-md-6">
									  
				{{ Form::text('open_time', $row['open_time'],array('class'=>'form-control datetime', 'style'=>'width:150px !important;')) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="开发商" class=" control-label col-md-4 text-left"> 开发商 </label>
									<div class="col-md-6">
									  {{ Form::text('developer', $row['developer'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="地址" class=" control-label col-md-4 text-left"> 地址 </label>
									<div class="col-md-6">
									  {{ Form::text('address', $row['address'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="售楼处电话" class=" control-label col-md-4 text-left"> 售楼处电话 </label>
									<div class="col-md-6">
									  {{ Form::text('sale_phone', $row['sale_phone'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="售楼处地址" class=" control-label col-md-4 text-left"> 售楼处地址 </label>
									<div class="col-md-6">
									  {{ Form::text('sale_address', $row['sale_address'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="物业公司" class=" control-label col-md-4 text-left"> 物业公司 </label>
									<div class="col-md-6">
									  {{ Form::text('property', $row['property'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="建筑类型" class=" control-label col-md-4 text-left"> 建筑类型 </label>
									<div class="col-md-6">
									  {{ Form::text('building_type', $row['building_type'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="建筑面积" class=" control-label col-md-4 text-left"> 建筑面积 </label>
									<div class="col-md-6">
									  {{ Form::text('building_area', $row['building_area'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="绿化率" class=" control-label col-md-4 text-left"> 绿化率 </label>
									<div class="col-md-6">
									  {{ Form::text('greening_rate', $row['greening_rate'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="楼盘特色" class=" control-label col-md-4 text-left"> 楼盘特色 </label>
									<div class="col-md-6">
									  {{ Form::text('feature', $row['feature'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="规划面积" class=" control-label col-md-4 text-left"> 规划面积 </label>
									<div class="col-md-6">
									  {{ Form::text('planning_area', $row['planning_area'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="建筑装修" class=" control-label col-md-4 text-left"> 建筑装修 </label>
									<div class="col-md-6">
									  {{ Form::text('decoration', $row['decoration'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="容积率" class=" control-label col-md-4 text-left"> 容积率 </label>
									<div class="col-md-6">
									  {{ Form::text('volume_ratio', $row['volume_ratio'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="车位数" class=" control-label col-md-4 text-left"> 车位数 </label>
									<div class="col-md-6">
									  {{ Form::text('parking', $row['parking'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="物业类型" class=" control-label col-md-4 text-left"> 物业类型 </label>
									<div class="col-md-6">
									  {{ Form::text('property_type', $row['property_type'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="规划户数" class=" control-label col-md-4 text-left"> 规划户数 </label>
									<div class="col-md-6">
									  {{ Form::text('household', $row['household'],array('class'=>'form-control', 'placeholder'=>'',   )) }} 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="是否显示在前台" class=" control-label col-md-4 text-left"> 是否显示在前台 </label>
									<div class="col-md-6">
									  
					<label class='radio radio-inline'>
					<input type='radio' name='active' value ='yes'  @if($row['active'] == 'yes') checked="checked" @endif > 显示 </label>
					<label class='radio radio-inline'>
					<input type='radio' name='active' value ='no'  @if($row['active'] == 'no') checked="checked" @endif > 不显示 </label> 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="所属城市" class=" control-label col-md-4 text-left"> 所属城市 <span class="asterix"> * </span></label>
									<div class="col-md-6">
									  <select name='city_id' rows='5' id='city_id' code='{$city_id}' 
							class='select2 '  required  ></select> 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> 					
								  <div class="form-group  " >
									<label for="Loc Id" class=" control-label col-md-4 text-left"> Loc Id </label>
									<div class="col-md-6">
									  <textarea name='loc_id' rows='2' id='loc_id' class='form-control '  
				           >{{ $row['loc_id'] }}</textarea> 
									 </div> 
									 <div class="col-md-2">
									 	
									 </div>
								  </div> </fieldset>
			</div>
			
			
			<div style="clear:both"></div>	
				
			  <div class="form-group">
				<label class="col-sm-4 text-right">&nbsp;</label>
				<div class="col-sm-8">	
				<input type="submit" name="apply" class="btn btn-info" value="{{ Lang::get('core.sb_apply') }} " />
				<input type="submit" name="submit" class="btn btn-primary" value="{{ Lang::get('core.sb_save') }}  " />
				<button type="button" onclick="location.href='{{ URL::to('estates?md='.$masterdetail["filtermd"].$trackUri) }}' " id="submit" class="btn btn-success ">  {{ Lang::get('core.sb_cancel') }} </button>
				</div>	  
		
			  </div> 
		 
		 {{ Form::close() }}
</div>	
</div>			 
   <script type="text/javascript">
	$(document).ready(function() { 
		
		$("#city_id").jCombo("{{ URL::to('estates/comboselect?filter=cities:id:name') }}",
		{  selected_value : '{{ $row["city_id"] }}' });
		 
	});
	</script>		 