get_ssm_parameter() {
  local full_parameter_name="/$1/$2/$3"

  if [ "$4" != "secure" ]
  then
    echo $(aws ssm get-parameter --name $full_parameter_name --output text --query Parameter.Value)
  else
    echo $(aws ssm get-parameter --name $full_parameter_name --with-decryption --output text --query Parameter.Value)
  fi
}
