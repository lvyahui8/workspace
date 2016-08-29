<?php

class OrdersController extends \BaseController {

	/**
	 * Display a listing of the resource.
	 *
	 * @return Response
	 */
	public function index()
	{
		//
	}


    public function reOrder(){
        //print_r($_POST);
        //print_r($_SERVER);
        $redirect = $_SERVER['HTTP_REFERER'];
        $id = $_POST['id'];
        $pid = $_POST['pid'];
        $nid = $_POST['nid'];
        $table = $_POST['table'];

        $item = DB::table($table)->where('id',$id)->first();
        $pitem = DB::table($table)->where('id',$pid)->first();
        $nitem = DB::table($table)->where('id',$nid)->first();
        //print_r($item);
        ///*
        if(!$pitem){
            $item->order = $nitem->order -1;
        }else if(!$nitem){
            $item->order = $pitem->order + 5;
        }
        else if(intval($pitem->order)+1 < intval($nitem->order)){
            $item->order = intval($pitem->order)+1;
        }else{
            //将后面的往后面挪
            $rows = DB::table($table)->where('order','>',$pitem->order)->get();
            $count = count($rows);
            for($i=0;$i<$count;$i++){
                $rows[$i]->order += 1;
                DB::table($table)->where('id',$rows[$i]->id)->update(array('order'=>$rows[$i]->order));
                if($i+1<$count && intval($rows[$i]->order) < intval($rows[$i+1]->order)){
                    break;
                }
            }
        }
        DB::table($table)->where('id',$id)->update(array('order'=>$item->order));

        //Redirect::to($redirect);
        return Response::json(array('success' => 'true', 'redirect' => $redirect));
        //*/
    }

	/**
	 * Show the form for creating a new resource.
	 *
	 * @return Response
	 */
	public function create()
	{
		//
	}


	/**
	 * Store a newly created resource in storage.
	 *
	 * @return Response
	 */
	public function store()
	{
		//
	}


	/**
	 * Display the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function show($id)
	{
		//
	}


	/**
	 * Show the form for editing the specified resource.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function edit($id)
	{
		//
	}


	/**
	 * Update the specified resource in storage.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function update($id)
	{
		//
	}


	/**
	 * Remove the specified resource from storage.
	 *
	 * @param  int  $id
	 * @return Response
	 */
	public function destroy($id)
	{
		//
	}


}
