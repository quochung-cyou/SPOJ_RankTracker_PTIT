package com.quochung.spojproptit_d21.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.quochung.spojproptit_d21.Model.Member;
import com.quochung.spojproptit_d21.R;

import java.util.ArrayList;

public class ParseAdapter extends RecyclerView.Adapter<ParseAdapter.ViewHolder> {

    private ArrayList<Member> memberlist;
    private Context context;
    private int lastpos = -1;

    public ParseAdapter(ArrayList<Member> memberlist, Context context) {
        this.memberlist = memberlist;
        this.context = context;
    }

    @NonNull
    @Override
    public ParseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.memberview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParseAdapter.ViewHolder holder, int position) {
        Member member = memberlist.get(position);
        holder.username.setText(member.getUsername());
        holder.problemscount.setText(member.getProblemamount() + " bài");
        holder.xephang.setText(member.getXephang());
        holder.tenthat.setText(member.getRealname());
        Glide.with(context).load(member.getAvatarurl()).placeholder(R.drawable.pro).into(holder.avatar);
        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.slide_in_left);
        holder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return memberlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView username, problemscount, xephang, tenthat;
        ImageView avatar;

        public ViewHolder(@NonNull View view) {
            super(view);
            username = view.findViewById(R.id.username);
            problemscount = view.findViewById(R.id.problemcount);
            xephang = view.findViewById(R.id.xephang);
            avatar = view.findViewById(R.id.avatar);
            tenthat = view.findViewById(R.id.tenthat);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}