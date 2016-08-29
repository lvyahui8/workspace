<?php
class Cities extends BaseModel  {
	
	protected $table = 'cities';
	protected $primaryKey = 'id';

	public function __construct() {
		parent::__construct();
		
	}

	public static function querySelect(  ){
		
		
		return "  SELECT cities.* FROM cities  ";
	}
	public static function queryWhere(  ){
		
		return " WHERE cities.id IS NOT NULL   ";
	}
	
	public static function queryGroup(){
		return "  ";
	}
	

}
