<?php
class Regions extends BaseModel  {
	
	protected $table = 'regions';
	protected $primaryKey = 'id';

	public function __construct() {
		parent::__construct();
		
	}

	public static function querySelect(  ){
		
		
		return "  SELECT regions.* FROM regions  ";
	}
	public static function queryWhere(  ){
		
		return " WHERE regions.id IS NOT NULL   ";
	}
	
	public static function queryGroup(){
		return "  ";
	}
	

}
