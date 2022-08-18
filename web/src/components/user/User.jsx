import React from 'react'
import './user.css';

const User = ({user, index}) => {
  return (
    <tr className='user__container'>
        <th scope="col">{index}</th>
        <th scope="col">{user.name}</th>
        <th scope="col">{user.role}</th>
        <th scope="col">{user.salary}</th>
        <th scope="col">{user.email}</th>
    </tr>
  )
}

export default User