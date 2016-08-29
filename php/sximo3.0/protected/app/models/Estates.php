<?php
class Estates extends BaseModel  {
	
	protected $table = 'estates';
	protected $primaryKey = 'id';

	public function __construct() {
		parent::__construct();
		
	}

	public static function querySelect(  ){
		
		
		return "  SELECT estates.* FROM estates  ";
	}
	public static function queryWhere(  ){
		
		return " WHERE estates.id IS NOT NULL   ";
	}
	
	public static function queryGroup(){
		return "  ";
	}
	

}
