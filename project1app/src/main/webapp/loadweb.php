

<?

if (isset($_POST['url'])){
  $url =($_POST['url']);
  echo <<<_END
  <iframe src="$url" style='height:250px' class='webupload'> </iframe>
_END;
}


?>
