import React from 'react';

import { Outlet } from 'react-router-dom';

import Navbar from './Navbar';


function Pateintroute(props) {
    return (
        <div>
            
      
    


      <Navbar />
      {/* <Routes>
        <Route path="/appointment" element={<Appointments />} />
        <Route path="/support" element={<Support />} />
        <Route path="/profile" element={<Profile />} />
      </Routes> */}

      <Outlet/>

        </div>
    );
}

export default Pateintroute;