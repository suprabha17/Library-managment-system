import ApiService from "../../services/ApiService";
import { useState } from "react";
import { Link, useHistory, useParams } from "react-router-dom";
import { useEffect } from "react/cjs/react.development";
import { ToastContainer, toast } from 'react-toastify';
  import 'react-toastify/dist/ReactToastify.css';

const UpdateUserForm = () => {
    const[name, setName] = useState('');
    const[email, setEmail] = useState('');
    const[password, setPassword] = useState('');
	const[address, setAddress]=useState('');
    const history = useHistory();
    const {id} = useParams();

    const saveUser = (e) => {
        e.preventDefault();
        
        const data = {name, email, password,address, id};
        if (id) {
            //update
            ApiService.updateMember(data)
                .then(response => {
                    console.log('Employee data updated successfully', response.data);
					toast('added successfully',response.data);
                    history.push('/allmemberdetails');
                })
                .catch(error => {
				toast("Something went wrong");
                    console.log('Something went wrong', error);
                }) 
        }
    }

    useEffect(() => {
        if (id) {
            ApiService.memberById(id)
                .then(user => {
                    setName(user.data.name);
                    setEmail(user.data.email);
                    setPassword(user.data.password);
					setAddress(user.data.address);
                })
				
                .catch(error => {
                    console.log('Something went wrong', error);
                })
        }
    }, [])
    return(
        <>
        <div className="whole-page"  >
        <div className="container" style={{marginTop:"80px"}}>
        <h3>Update user </h3> 
           <div style={{marginTop:"80px"}} >
            <form>
                <div className="form-group">
                    <input 
                        type="text" 
                        className="form-control col-4"
                        id="name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        placeholder="Enter name"
                    />
         
                </div>
                <div className="form-group">
                    <input 
                        type="text" 
                        className="form-control col-4"
                        id="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        placeholder="Enter Department"
                    />
                            
                </div>
                <div className="form-group">
                    <input 
                        type="text" 
                        className="form-control col-4"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        placeholder="Enter password"
                    />
                </div>
				<div className="form-group">
                    <input 
                        type="text" 
                        className="form-control col-4"
                        id="address"
                        value={address}
                        onChange={(e) => setAddress(e.target.value)}
                        placeholder="Enter address"
                    />
                </div>
                <div >
                    <button onClick={(e) => saveUser(e)} className="btn btn-primary">Update</button>
                </div>
            </form>
            <hr/>
            <Link to="/allmemberdetails">Back to List</Link>
        </div>
        </div>
        </div>
        <ToastContainer/>
</>
        
    )
}
export default UpdateUserForm;