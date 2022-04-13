import { useForm } from 'react-hook-form';
import React from 'react';
import classNames from 'classnames';
import { useRef } from 'react';
import ApiService from '../../services/ApiService';
import { useHistory } from 'react-router-dom';
import { Link } from "react-router-dom";
// import React, { Component }  from 'react';


const MemberRegistration = () => {

    const history = useHistory();
    const { register, handleSubmit, formState: { errors }, watch } = useForm({ mode: "onChange" });
    const password = useRef({});
    password.current = watch("password", "");

    const submitHandler = (data) => {

        console.log("insubmit")
        console.log(JSON.stringify(data));
        ApiService.memberRegistration(JSON.stringify(data))
            .then(resp=>{
                console.log(resp.data);
                history.push({
                    pathname: '/login',
                    state: { message: resp.data }
                });
            }).catch(err => {
                alert("already registered with this emailId");
                console.log(err);
            })
    }  

    return (
        <form onSubmit={handleSubmit(submitHandler)} method="post" className="needs-validation" noValidate autoComplete="off">
            <p>Please fill in this form to create an account!</p>
            <hr />
            <div className="form-group">
                <div className="row">
                
                    <div className="col position-relative">
                        <input type="text" className={classNames("form-control",{"is-invalid": errors.name})} name="name" placeholder="Name" 
                        {...register('name', { 
                            required: "Please enter your full name.",
                            minLength: {
                                value: 4,
                                message: "Should be at least 4 characters"
                            },
                            pattern: {
                                value: /^(?![ ])[a-zA-Z ]+(?<! )$/,
                                message: "Invalid name."
                            }
                        })}
                        />
                        {errors.name && <div className="invalid-tooltip">{errors.name.message}</div>}
                    </div>
                </div>
            </div>
            <div className="form-group">
                <div className="col position-relative">
                    <input type="email" className={classNames("form-control",{"is-invalid": errors.email})}  name="email" placeholder="Email"
                        {...register('email', { 
                                required: "Please enter your email.",
                                pattern: {
                                    value: /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
                                    message: "Invalid email."
                                }
                            }
                        )}
                    />
                    {errors.email && <div className="invalid-tooltip">{errors.email.message}</div>}
                </div>
            </div>
            <div className="form-group">
                <div className="row">
                    <div className="col position-relative">
                        <input type="password" className={classNames("form-control",{"is-invalid": errors.password})} name="password" placeholder="Password" 
                            {...register('password', { 
                                    required: "Please enter your password.",
                                    minLength: {
                                        value: 5,
                                        message: "Should be at least 5 characters."
                                    }
                                }
                            )}
                        />
                        {errors.password && <div className="invalid-tooltip">{errors.password.message}</div>}
                    </div>
                    
                </div>
            </div>
            <div className="form-group">
                <div className="row">
                    <div className="col position-relative">
                        <input type="text" className={classNames("form-control",{"is-invalid": errors.address})} name="address" placeholder="Address" 
                            {...register('address', { 
                                    required: "Please enter your address.",
                                    minLength: {
                                        value: 4,
                                        message: "Should be at least 4 characters."
                                    }
                                }
                            )}
                        />
                        {errors.address && <div className="invalid-tooltip">{errors.address.message}</div>}
                    </div>
                </div>
            </div>
            {/* <div className="form-group">
                <label className="form-check-label">
                    <input type="checkbox" className={classNames("form-check-input", {"is-invalid": errors.tnc})} name="tnc"
                        {...register('tnc', { 
                                required: "Please agree to the terms and conditions."
                            }
                        )} 
                    /> I hereby declare that the above information is true to the best of my knowledge.
                </label>
            </div> */}
            <div className="form-group">
            <button type="submit" className="btn btn-primary btn-lg text-dark" onClick={submitHandler}>Sign Up</button>

                {/* <button type="submit" className="btn btn-primary btn-lg text-dark">Sign Up</button> */}
            </div>
        </form>
    )
}

export default MemberRegistration