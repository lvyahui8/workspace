<?php
class Estateloc extends BaseModel  {
	
	protected $table = 'estate_loc';
	protected $primaryKey = 'id';

	public function __construct() {
		parent::__construct();
		
	}

	public static function querySelect(  ){
		
		
		return "  SELECT estate_loc.* FROM estate_loc  ";
	}
	public static function queryWhere(  ){
		
		return " WHERE estate_loc.id IS NOT NULL   ";
	}
	
	public static function queryGroup(){
		return "  ";
	}
	

}
