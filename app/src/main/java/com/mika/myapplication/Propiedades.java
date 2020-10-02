package com.mika.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Propiedades extends AppCompatActivity {
    private ViewPager viewPager;
    private AppBarLayout appBar;
    private TabLayout tabLayout;
    private PropiedadesViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propiedades);
        inicializar();
    }
    public void inicializar(){
        viewPager= findViewById(R.id.pager);
        appBar=findViewById(R.id.appBar);
        tabLayout= new TabLayout(this);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(PropiedadesViewModel.class);
        appBar.addView(tabLayout);
        vm.getInmuebles().observe(this, new Observer<ArrayList<Inmueble>>() {
            @Override
            public void onChanged(ArrayList<Inmueble> inmuebles) {
                ViewPageAdapter adapter= new ViewPageAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
                int numero= 0;
                for(Inmueble inmueble :inmuebles) {
                    numero ++;
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("inmueble",inmueble);
                    InmuebleFragment fragment= new InmuebleFragment();
                    fragment.setArguments(bundle);
                    adapter.addFragments(fragment,"Inmueble "+ numero);
                }
                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        vm.cargarInmuebles();
    }

    public class ViewPageAdapter extends FragmentPagerAdapter{
        private List<Fragment> inmuebles= new ArrayList<>();
        private List<String> titulos= new ArrayList<>();
        public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return inmuebles.get(position);
        }

        @Override
        public int getCount() {
            return inmuebles.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titulos.get(position);
        }
        public void addFragments(Fragment fragment,String titulo){
            inmuebles.add(fragment);
            titulos.add(titulo);
        }
    }
}