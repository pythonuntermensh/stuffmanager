import React from 'react'
import './options.css';

const Options = () => {
  return (
    <div className="options__container">
        <label>Sort by:</label>
        <select id="order">
            <option selected="">Id</option>
            <option>Name</option>
            <option>Role</option>
            <option>Salary</option>
        </select>
        
        <div className="form__container">
            <label>Filter:</label>
            <form id="filterButton">
                <div className="form-row">
                    <label>Name</label>
                    <input type="text" placeholder="Name" />
                </div>
                <div className="form-row">
                    <label>Salary</label>
                    <input type="number" min="0" step="1000" placeholder='Salary' />
                </div>
                <div className="form-row">
                    <label >Role</label>
                    <select>
                        <option selected="">CEO</option>
                        <option>CTO</option>
                        <option>Manager</option>
                        <option>Accountant</option>
                        <option>Cleaner</option>
                        <option>Security Guard</option>
                    </select>
                </div>
                <button type="button" className="btn btn-primary">Accept</button>
            </form>
        </div>

        <div className="form__container">
            <label>New Employee</label>
            <form id="createButton">
                <div className="form-row">
                    <label>Name</label>
                    <input type="text" placeholder="Name" />
                </div>
                <div className="form-row">
                    <label>Salary</label>
                    <input type="number" min="0" step="1000" placeholder='Salary' />
                </div>
                <div className="form-row">
                    <label >Role</label>
                    <select>
                        <option selected="">CEO</option>
                        <option>CTO</option>
                        <option>Manager</option>
                        <option>Accountant</option>
                        <option>Cleaner</option>
                        <option>Security Guard</option>
                    </select>
                </div>
                <div className="form-row">
                    <label>Email</label>
                    <input type="email" placeholder="Email" />
                </div>
                <div className="form-row">
                    <label>Password</label>
                    <input type="password" placeholder="Password" />
                </div>
                <button type="submit" className="btn btn-primary">Create</button>
            </form>
        </div>
    </div>
  )
}

export default Options