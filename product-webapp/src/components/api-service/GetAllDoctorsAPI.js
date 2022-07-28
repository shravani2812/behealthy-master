import  { useState,useEffect } from 'react';



const GetAllDoctorsAPI = () => {
   
    // 1
    const [alldoctors, usersSet] = useState([]);
  
    useEffect(() => {
      async function fetchAllDoctor() {
        const fullResponse = await fetch(`https://behealthy.stackroute.io/user/api/v1/doctor/getAllDoctor`);
        const responseJson = await fullResponse.json();
        console.log(responseJson);
        usersSet(responseJson);
      }
  
      fetchAllDoctor();
    }, []);
  
    // 2
  
    
    return [alldoctors];
  };
  export default GetAllDoctorsAPI;

