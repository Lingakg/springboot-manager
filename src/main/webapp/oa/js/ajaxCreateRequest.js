function CreateRequestObject(){  
    var ajaxRequest;  
    try{  
        //IE 8.0+, Firefox, Safari  
        ajaxRequest = new XMLHttpRequest();  
    }catch(e){//internet EXplore  
        try{  
            ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");  
              
        }catch(e){  
            try{//code for ie5 and ie6  
                ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");  
            }catch(e){  
                return false;  
            }  
        }  
    }  
    return ajaxRequest;  
}  