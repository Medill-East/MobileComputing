@echo off

if exist gyro.txt (

rem get lines from the 100rd line

  set n=1

  SetLocal EnableDelayedExpansion

  for /f "delims=" %%i in (gyro.txt) do (

    echo %%i

    if !n! geq 100 if !n! leq 200 (

      echo %%i >> 100to200gyro.txt

   ) else (

      echo not matching...

    )

    set /a n=!n!+1

  )

) else (

  echo not found gyro.txt

)
