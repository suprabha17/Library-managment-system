import React, {useState, useContext} from 'react'
import { useHistory } from 'react-router';

import ApiService from '../../services/ApiService';

import { Link } from 'react-router-dom';
import "react-toastify/dist/ReactToastify.css";

import { toast, ToastContainer } from 'react-toastify';


function ForgetPassword()  {
    const [email, setEmail] = useState();
 const [oldpassword, setOldPassword] = useState();
 const [newPassword, setNewPassword] = useState();
 const history = useHistory();
    const [errors, setErrors] = useState({});
    const [values, setValues] = useState({
    
        email: "",
        oldpassword: "",
        newPassword:""
      });
      const handleLogin = (props) =>{
        props.preventDefault();
        const user = {email,oldpassword ,newPassword};
        ApiService.resetPAssword(user).then(response=>{
            localStorage.setItem("user",JSON.stringify(response));
            toast("password reset successfuly");
            localStorage.setItem('isChanged',response);
           alert("password changed successfully");
            history.push('/login');
            toast("password reset successfuly");
          
        })
        .catch(error=>{
            console.log(error);
            toast("old password is wrong");
            history.push("/forgetpassword");
        })
      };
      return (
        <>
        <div className="whole-page"  >
        <div className="container" style={{marginTop:"80px"}}>
        <h3>Change your Password</h3> 
           <div style={{marginTop:"80px"}} >
           <br></br>
           
               <div className="form-group" class="col-md-3">
          <label className="passs">EMAIL :</label>    
             <input
              type="email"
              className="form-control"
              name="email"
              id="email"
              value={email}
              //onChange={handleChange}
              onChange={(e) => setEmail(e.target.value)}
              placeholder="example@test.com"
            />
            <br></br>
            </div>
           <div className="form-group" class="col-md-3">
          <label className="passs">OLDPASSWORD :</label>
              <input
              type="password"
              className="form-control"
              name="oldpassword"
              id="oldpassword"
              // name="password"
              placeholder="enter old password" 
              value={oldpassword}
              //onChange={handleChange}
              onChange={(e) => setOldPassword(e.target.value)}
            />
            <br></br>
            </div>

            <div className="form-group" class="col-md-3">
            <label className="passs">New PASSWORD : </label>
              <input
              className="form-control"
              type="password"
              name="password"
              id="newpassword"
              // name="password"
              placeholder="enter new password" 
              value={newPassword}
              //onChange={handleChange}
              onChange={(e) => setNewPassword(e.target.value)}
            />
            <br></br>
             </div>
             <div className="form-group" class="col-md-3">
             <button className="btn_login"
              type="submit"
              class="btn btn-primary col-md-5" 
              onClick={(props) => handleLogin(props)}
            >
              Submit
            </button>
            </div>
            <Link to="/AddUser"><span className="pass"> Register</span> </Link>

</div>
               </div>
              
               </div>
               <ToastContainer/>
               </>
      );


}
export default ForgetPassword;





